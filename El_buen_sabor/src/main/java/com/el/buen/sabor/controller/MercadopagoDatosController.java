package com.el.buen.sabor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.buen.sabor.entity.MercadopagoDatos;
import com.el.buen.sabor.entity.Pedido;
import com.el.buen.sabor.service.MercadopagoDatosService;
import com.formaciondbi.microservicios.generics.controllers.ControllerImpl;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/mercadopagoDatos")
public class MercadopagoDatosController extends ControllerImpl<MercadopagoDatos, ServicesImpl<MercadopagoDatos,Long>>{

	@Autowired
	MercadopagoDatosService service;
	
	@PostMapping("/checkoutmp/{idu}/pedido/{idp}")
	public ResponseEntity<?> checkoutMercadoPago(@RequestBody Pedido pedido, @PathVariable Long idu, @PathVariable Long idp) throws MPException {
		MercadoPago.SDK.setAccessToken("APP_USR-1109909425044731-043001-bcc92ae49c03a4518181d64675c3f982-736455939");
		
		Preference preference = new Preference();

		try {
		
			// Crea un ítem en la preferencia
			Item item = new Item();
			item.setTitle("Pedido Nro "+pedido.getNumero())
			    .setQuantity(1)
			    .setUnitPrice((float) pedido.getTotal());
			preference.appendItem(item);
			preference.setExternalReference(pedido.getId().toString());
			BackUrls backUrls = new BackUrls(
                    "http://localhost:4200/exitoso/"+idu+"/pedido/"+idp,
                    "http://localhost:4200/pendiente/"+idu+"/pedido/"+idp,
                    "http://localhost:4200/error/"+idu+"/pedido/"+idp);
			//home succes --- login pending --- register error

			preference.setBackUrls(backUrls);
			preference.save();
		
			//String idp= new String(preference.getId());
			//String pa = "{'id': '"+preference.getId()+"' }";
			//JSONParser parser = new JSONParser(); 
			//JSONObject json = (JSONObject) parser.parse(pa);
			
			MercadopagoDatos mpd = new MercadopagoDatos();
			mpd.setPreferenceId(preference.getId());
			
			//JSONParser parser = new JSONParser(); 
			//JSONObject json = (JSONObject) parser(mpd);
			
			
			return ResponseEntity.status(HttpStatus.OK).body(mpd);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"error por favor intente mas tarde.\"}"+e.getMessage());
		}
	}
	
	
}

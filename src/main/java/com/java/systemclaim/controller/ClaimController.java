package com.java.systemclaim.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.java.systemclaim.model.Claim;
import com.java.systemclaim.model.Client;
import com.java.systemclaim.service.ClaimService;
import com.java.systemclaim.service.ClientService;

@Controller
@SessionAttributes("client")
public class ClaimController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClaimService claimService;
	
	/*@ModelAttribute("client")
	public Client client() {
	    return new Client();
	}*/
	
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
/*		Client client = new Client();
		
		Claim claim = new Claim();
//		claim.setId(1);
		claim.setRequest("Clean a room");
		claim.setBid(12.5);
		claim.setDueDate(new Date());
		claim.setStatus("denied");
		claim.setClient(client);
		Claim claim2 = new Claim();
//		claim2.setId(2);
		claim2.setRequest("Clean a room2");
		claim2.setBid(25);
		claim2.setDueDate(new Date());
		claim2.setStatus("denied");
		claim2.setClient(client);
		List<Claim> list = new ArrayList<>();
		list.add(claim);
		list.add(claim2);
		
//		client.setId(1);
		client.setName("Nick");
		client.setLogin("snvbel@mail.ru");
		client.setPassword("snvnosnv");
		client.setStatus("admin");
		client.setClaims(list);
		
		clientService.addClient(client);*/
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
}
	@RequestMapping(value={"/main"}, method = RequestMethod.GET)
	public ModelAndView main(@RequestParam String login, @RequestParam String password){
		Client client = clientService.getByLoginAndPassw(login, password);
		ModelAndView modelAndView = new ModelAndView();
		if(client == null) {
			modelAndView.addObject("warning", "Вы ввели неверный логин или пароль");
			modelAndView.setViewName("login");
			return modelAndView;
		} else {
			modelAndView.addObject("client", client);
			modelAndView.setViewName("main");
			return modelAndView;
		}
	}
	
	@RequestMapping(value={"/clientStatusRequests"}, method = RequestMethod.GET)
	public ModelAndView clientStatusRequests(@ModelAttribute("client") Client client){
		Client tmp = clientService.getByID(client.getId());		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allClaims", tmp.getClaims());
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	@RequestMapping(value={"/clientRequestRegister"}, method = RequestMethod.POST)
	public ModelAndView clientRequestRegister(@ModelAttribute("client") Client client, @RequestParam String request, @RequestParam String bid, @RequestParam String date) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Client tmp = clientService.getByID(client.getId());
		Claim claim = new Claim();
		claim.setRequest(request);
		claim.setBid(Double.parseDouble(bid));
		claim.setDueDate(formatter.parse(date));
		claim.setStatus("on consideration");
		claim.setClient(tmp);
		tmp.addClaim(claim);
		clientService.addClient(tmp);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	@RequestMapping(value={"/adminUpdateStatus"}, method = RequestMethod.POST)
	public ModelAndView adminUpdateStatus(@RequestParam Map<String,String> allRequestParams, HttpServletRequest request){
		Map<String, String[]> map = request.getParameterMap();/*purely with Spring help*/
		map.forEach((k,v) -> claimService.updateClaimStatusById(v[0], Integer.parseInt(k.substring(k.length() - 1))));
		/*for(Map.Entry<String, String[]> entry : map.entrySet()) {
		    String key = entry.getKey();
		    Integer id = Integer.parseInt(key.substring(key.length() - 1));
		    String[] value = entry.getValue();
		    String status = value[0];
		    claimService.updateClaimStatusById(status, id);
		}*/
		map.forEach((k,v) -> claimService.updateClaimStatusById(v[0], Integer.parseInt(k.substring(k.length() - 1))));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	@RequestMapping(value={"/adminStatusAll"}, method = RequestMethod.GET)
	public ModelAndView adminStatusAll(){
		List<Claim> tmp = claimService.getAll();		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allClaims", tmp);
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	@RequestMapping(value={"/adminStatusDone"}, method = RequestMethod.GET)
	public ModelAndView adminStatusDone(@RequestParam String submit){			
		List<Claim> tmp = claimService.getByStatus(submit);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allClaims", tmp);
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	@RequestMapping(value={"/adminStatusDenied"}, method = RequestMethod.GET)
	public ModelAndView adminStatusDenied(@RequestParam String submit){			
		List<Claim> tmp = claimService.getByStatus(submit);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allClaims", tmp);
		modelAndView.setViewName("main");
		return modelAndView;
	}
}

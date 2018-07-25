package it.polito.tdp.borders.db;

import java.util.List;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Border;

public class TestDAO {

	public static void main(String[] args) {

		BordersDAO dao = new BordersDAO();

//		System.out.println("Lista di tutte le nazioni:");
//		List<Country> countries = dao.loadAllCountries();
//		System.out.println(countries.toString());

		List<Border> borders = dao.getCountryPairs(1816);
		System.out.println(borders.toString());
	}
}

/*
[{AUH,SWZ}, {AUH,BAV}, {AUH,GMY}, {AUH,SAX}, {AUH,ITA}, {AUH,PAP}, {AUH,USR}, {AUH,TUR}, 
{BAD,FRN}, {BAD,SWZ}, {BAD,BAV}, {BAD,WRT}, {BAD,HSG}, 
{BAV,FRN}, {BAV,GMY}, {BAV,SAX}, {BAV,WRT}, {BAV,HSE}, {BAV,HSG}, 
{FRN,SPN}, {FRN,GMY}, {FRN,ITA}, 
{GMY,SAX}, {GMY,HSE}, {GMY,HSG}, {GMY,USR}, 
{HSE,HSG}, {ITA,SWZ}, {PAP,SIC}, {PAP,TUS}, {POR,SPN}, 
{RUS,SWD}, {RUS,TUR}]


220 FRN --> 225 SWZ, 
220 FRN --> 230 SPN, 
220 FRN --> 245 BAV, 
220 FRN --> 255 GMY, 
220 FRN --> 267 BAD, 
220 FRN --> 325 ITA, 
225 SWZ --> 220 FRN, 
225 SWZ --> 267 BAD, 
225 SWZ --> 300 AUH, 
225 SWZ --> 325 ITA, 
230 SPN --> 220 FRN, 
230 SPN --> 235 POR, 
235 POR --> 230 SPN, 
245 BAV --> 220 FRN, 
245 BAV --> 255 GMY, 
245 BAV --> 267 BAD, 
245 BAV --> 269 SAX, 
245 BAV --> 271 WRT, 
245 BAV --> 273 HSE, 
245 BAV --> 275 HSG, 
245 BAV --> 300 AUH, 
255 GMY --> 210 NTH, 
255 GMY --> 220 FRN, 
255 GMY --> 245 BAV, 
255 GMY --> 269 SAX, 
255 GMY --> 273 HSE, 
255 GMY --> 275 HSG, 
255 GMY --> 300 AUH, 
255 GMY --> 365 USR, 
267 BAD --> 220 FRN, 
267 BAD --> 225 SWZ, 
267 BAD --> 245 BAV, 
267 BAD --> 271 WRT, 
267 BAD --> 275 HSG, 
269 SAX --> 245 BAV, 
269 SAX --> 255 GMY, 
269 SAX --> 300 AUH, 
271 WRT --> 245 BAV, 
271 WRT --> 267 BAD, 
273 HSE --> 245 BAV, 
273 HSE --> 255 GMY, 
273 HSE --> 275 HSG, 
275 HSG --> 245 BAV, 
275 HSG --> 255 GMY, 
275 HSG --> 267 BAD, 
275 HSG --> 273 HSE, 
300 AUH --> 225 SWZ, 
300 AUH --> 245 BAV, 
300 AUH --> 255 GMY, 
300 AUH --> 269 SAX, 
300 AUH --> 325 ITA, 
300 AUH --> 327 PAP, 
300 AUH --> 365 USR, 
300 AUH --> 640 TUR, 
325 ITA --> 220 FRN, 
325 ITA --> 225 SWZ, 
325 ITA --> 300 AUH, 
327 PAP --> 300 AUH, 
327 PAP --> 329 SIC, 
327 PAP --> 337 TUS, 
329 SIC --> 327 PAP, 
337 TUS --> 327 PAP, 
365 USR --> 255 GMY, 
365 USR --> 300 AUH, 
365 USR --> 380 SWD, 
365 USR --> 640 TUR, 
380 SWD --> 365 USR, 
640 TUR --> 300 AUH, 
640 TUR --> 365 USR]
*/




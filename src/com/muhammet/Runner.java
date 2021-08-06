package com.muhammet;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Runner {

	// Deðiþkenler, Methodlar ve inner class lar olabilir.
	// Deðiþkenler, tanýmlý olduklarý süslü parantezlerin içinde var olurlar.
	// ve alt kýrýlýmlarda kullanýlabilirler
	// ANCAK, ayný seciye de ya da üst seviyede deðiþkenler tanýnmazlar.
	// UUID, birimi,personel,arýza türü, arýza açýklamasý,teknikpersonel, durumu
	static int arizasayisi=0;
	static String[][] ArizaListesi;
	static String[] TeknikPersonel = {"Muhammet","Hakan","Bahar","Cem","Mustafa"};
	static String[] ArizaTuru = {"Bilgisayar Arýzasý","Monitör Arýzasý","Yazýcý Arýzasý"};
	public static void main(String[] args) {
		
	
		int secim=0;
		
		do {
			
			ekranGoster();
			secim = islemSecimi();
			switch (secim) {
			case 1:	arizaKaydiAc();	break;
			case 2:	arizaKaydiGoruntulePersonel();break;
			case 3:	arizaKaydiGoruntuleTeknikPersonel();break;
			case 4:	arizaKaydiGuncelle();break;
			case 0:	System.out.println("UYGULAMA SONLANDIRILDI");break;			
			default:System.err.println("Lütfen Geçerli bir seçim yapýnýz.");break;
			}
		}while(secim!=0);
		
		
	}//Main Sonu
	static int arizaTuruSecimi() {
		int secimResult =0;
		boolean isTrueSelect= false;
		Scanner sc;
		System.out.println("** ARIZA TÜRÜNÜ SEÇÝNÝZ **");
		System.out.println("1- Bilgisayar Arýzasý");
		System.out.println("2- Monitör Arýzasý");
		System.out.println("3- Yazýcý Arýzasý");
		do{
			try {
				sc = new Scanner(System.in);
				System.out.print("Arýza türünü seçiniz....: ");
				secimResult = sc.nextInt();
				isTrueSelect= true;
			}catch(Exception ex) {
				System.err.println("Lütfen Geçerli bir seçim yapýnýz.");
			}
			if(isTrueSelect) {
				if(secimResult>=1 && secimResult<=3) {
					isTrueSelect= true;
				}else {
					isTrueSelect = false;
					System.err.println("Lütfen 1,2 ve 3  ten birini seçiniz. geçerli bir secim yapýnýz");
				}
				
			}
		}while(!isTrueSelect);
		
		return secimResult;
	}
	static void arizaKaydiAc() {
		System.out.println("**** ARIZA KAYDI AÇMA EKRANI ****");
		Scanner sc = new Scanner(System.in);
		System.out.print("Birim adý.............: ");
		String birim_adi = sc.nextLine();
		System.out.print("Pesonel adý...........: ");
		String personel_adi = sc.nextLine();
		int arizaTuru = arizaTuruSecimi();
		System.out.println("Arýza Açýklamasý....: ");
		String ariza_aciklamasi = sc.nextLine();
		arizaListesiGenislet();
		// UUID -> Benzersiz etiket 
		//System.out.println("benzersiz id......: "+ UUID.randomUUID());
		ArizaListesi[arizasayisi-1][0] = UUID.randomUUID().toString();
		ArizaListesi[arizasayisi-1][1] = birim_adi;
		ArizaListesi[arizasayisi-1][2] = personel_adi;
		ArizaListesi[arizasayisi-1][3] = ArizaTuru[arizaTuru-1];
		Random rd = new Random();
		int teknik_personel_index = rd.nextInt(4);
		ArizaListesi[arizasayisi-1][4] = TeknikPersonel[teknik_personel_index];
		ArizaListesi[arizasayisi-1][5] = "AÇIK";
		
	}
	static void arizaListesiGenislet() {
		if(arizasayisi==0) {
			ArizaListesi = new String[1][6];
			arizasayisi++;
		}else {
			// Mevcut kayýtlar var, önce onlarý baþka bir diziye al;
			// sonra mevcut diziyi geniþlet
			// geçici baþka diziye aldýðýn kayýtlarý geniþlettiðin diziye aktar.
			String[][] tmp = new String[arizasayisi][6];
			for(int i=0;i<arizasayisi;i++) {
				tmp[i][0]= ArizaListesi[i][0];
				tmp[i][1]= ArizaListesi[i][1];
				tmp[i][2]= ArizaListesi[i][2];
				tmp[i][3]= ArizaListesi[i][3];
				tmp[i][4]= ArizaListesi[i][4];
				tmp[i][5]= ArizaListesi[i][5];				
			}
			arizasayisi++;
			ArizaListesi = new String[arizasayisi][6];
			for(int i=0;i<arizasayisi-1;i++) {
				ArizaListesi[i][0]= tmp[i][0];
				ArizaListesi[i][1]= tmp[i][1];
				ArizaListesi[i][2]= tmp[i][2];
				ArizaListesi[i][3]= tmp[i][3];
				ArizaListesi[i][4]= tmp[i][4];
				ArizaListesi[i][5]= tmp[i][5];				
			}
		}
		
	}
	static void arizaKaydiGoruntulePersonel() {
			
	}
	static void arizaKaydiGoruntuleTeknikPersonel() {
		System.out.println("** ARIZA LÝSTESÝ  GÖRÜNTÜLEME EKRANI **");
		System.out.println();
		System.out.println("UUID                  		  | Birimi     | Personel    | Arýza Türü   |  Teknik Personel  | Durumu");
		for(int i=0; i<arizasayisi;i++) {
			System.out.print(ArizaListesi[i][0]+"  ");
			System.out.print(ArizaListesi[i][1]+"  ");
			System.out.print(ArizaListesi[i][2]+"  ");
			System.out.print(ArizaListesi[i][3]+"  ");
			System.out.print(ArizaListesi[i][4]+"  ");
			System.out.print(ArizaListesi[i][5]+"  ");	
			System.out.println("");
		}
		System.out.println("");
	}
	
	static void arizaKaydiGuncelle() {
		
	}

	static int islemSecimi() {
		Scanner sc;
		int secimResult=0;
		boolean istrueSelect = false;
		do {
			sc = new Scanner(System.in);
			try {
				System.out.print("Seçiniz...: ");
				secimResult = sc.nextInt();
				istrueSelect = true;
			}catch(Exception ex){
				System.out.println("Lütfen geçerli bir deðer giriniz.");
			}
					
		}while(!istrueSelect);
		
		return secimResult;
	}
	
	static void ekranGoster() {
		System.out.println("**************************************");
		System.out.println("****** TEKNÝK DESTEK PROGRAMI ********");
		System.out.println("**************************************");
		System.out.println("1- Arýza Kaydý Aç");
		System.out.println("2- Arýza Kaydý Görüntüle - PERSONEL");
		System.out.println("3- Arýza Kaydý Görüntüle - TEKNÝK PERSONEL");
		System.out.println("4- Arýza Kaydý Gücelle");
		System.out.println("0- ÇIKIÞ");	
		
	}
}//Class Sonu 

package com.muhammet;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Runner {

	// De�i�kenler, Methodlar ve inner class lar olabilir.
	// De�i�kenler, tan�ml� olduklar� s�sl� parantezlerin i�inde var olurlar.
	// ve alt k�r�l�mlarda kullan�labilirler
	// ANCAK, ayn� seciye de ya da �st seviyede de�i�kenler tan�nmazlar.
	// UUID, birimi,personel,ar�za t�r�, ar�za a��klamas�,teknikpersonel, durumu
	static int arizasayisi=0;
	static String[][] ArizaListesi;
	static String[] TeknikPersonel = {"Muhammet","Hakan","Bahar","Cem","Mustafa"};
	static String[] ArizaTuru = {"Bilgisayar Ar�zas�","Monit�r Ar�zas�","Yaz�c� Ar�zas�"};
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
			default:System.err.println("L�tfen Ge�erli bir se�im yap�n�z.");break;
			}
		}while(secim!=0);
		
		
	}//Main Sonu
	static int arizaTuruSecimi() {
		int secimResult =0;
		boolean isTrueSelect= false;
		Scanner sc;
		System.out.println("** ARIZA T�R�N� SE��N�Z **");
		System.out.println("1- Bilgisayar Ar�zas�");
		System.out.println("2- Monit�r Ar�zas�");
		System.out.println("3- Yaz�c� Ar�zas�");
		do{
			try {
				sc = new Scanner(System.in);
				System.out.print("Ar�za t�r�n� se�iniz....: ");
				secimResult = sc.nextInt();
				isTrueSelect= true;
			}catch(Exception ex) {
				System.err.println("L�tfen Ge�erli bir se�im yap�n�z.");
			}
			if(isTrueSelect) {
				if(secimResult>=1 && secimResult<=3) {
					isTrueSelect= true;
				}else {
					isTrueSelect = false;
					System.err.println("L�tfen 1,2 ve 3  ten birini se�iniz. ge�erli bir secim yap�n�z");
				}
				
			}
		}while(!isTrueSelect);
		
		return secimResult;
	}
	static void arizaKaydiAc() {
		System.out.println("**** ARIZA KAYDI A�MA EKRANI ****");
		Scanner sc = new Scanner(System.in);
		System.out.print("Birim ad�.............: ");
		String birim_adi = sc.nextLine();
		System.out.print("Pesonel ad�...........: ");
		String personel_adi = sc.nextLine();
		int arizaTuru = arizaTuruSecimi();
		System.out.println("Ar�za A��klamas�....: ");
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
		ArizaListesi[arizasayisi-1][5] = "A�IK";
		
	}
	static void arizaListesiGenislet() {
		if(arizasayisi==0) {
			ArizaListesi = new String[1][6];
			arizasayisi++;
		}else {
			// Mevcut kay�tlar var, �nce onlar� ba�ka bir diziye al;
			// sonra mevcut diziyi geni�let
			// ge�ici ba�ka diziye ald���n kay�tlar� geni�letti�in diziye aktar.
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
		System.out.println("** ARIZA L�STES�  G�R�NT�LEME EKRANI **");
		System.out.println();
		System.out.println("UUID                  		  | Birimi     | Personel    | Ar�za T�r�   |  Teknik Personel  | Durumu");
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
				System.out.print("Se�iniz...: ");
				secimResult = sc.nextInt();
				istrueSelect = true;
			}catch(Exception ex){
				System.out.println("L�tfen ge�erli bir de�er giriniz.");
			}
					
		}while(!istrueSelect);
		
		return secimResult;
	}
	
	static void ekranGoster() {
		System.out.println("**************************************");
		System.out.println("****** TEKN�K DESTEK PROGRAMI ********");
		System.out.println("**************************************");
		System.out.println("1- Ar�za Kayd� A�");
		System.out.println("2- Ar�za Kayd� G�r�nt�le - PERSONEL");
		System.out.println("3- Ar�za Kayd� G�r�nt�le - TEKN�K PERSONEL");
		System.out.println("4- Ar�za Kayd� G�celle");
		System.out.println("0- �IKI�");	
		
	}
}//Class Sonu 

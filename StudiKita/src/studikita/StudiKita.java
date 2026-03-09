/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studikita;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Lab Informatika
 */
public class StudiKita {
    static ArrayList<Peserta> daftarPeserta = new ArrayList<>();
    static ArrayList<PaketKursus> daftarPaketKursus = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean kondisi = true;
        
        while(kondisi) {
            System.out.println("\n=== SISTEM KURSUS STUDIKITA ===");
            System.out.println("1. Daftar Peserta");
            System.out.println("2. Keluar");
            System.out.print("Pilih Menu: ");
            
            String pilih = sc.nextLine().trim();
            
            switch (pilih) {
                case "1":
                    tambahPeserta(sc);
                    break;
                case "2":
                    kondisi = false;
                    rekapPeserta();
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");
            }
        }
        sc.close();
    }
    
    static void tambahPeserta(Scanner sc){
        System.out.println("\n--- DATA PESERTA ---");
        System.out.println("Nama    : ");
        String nama = sc.nextLine().trim();
        System.out.println("Nomor Telepon    : ");
        String nomorTelepon = sc.nextLine().trim();
        
        if(!nomorTelepon.matches("\\d+")) {
            System.out.println("Nomor Telepon Harus Berupa Angka");
            return;
        }
        System.out.println("\n--- DATA PAKET ---");
        System.out.println("Harga Kursus    : ");
        double hargaKursus;
        try{
            hargaKursus = Double.parseDouble(sc.nextLine().trim());
        } catch(NumberFormatException e){
            System.out.println("ERROR : HARGA KURSUS TIDAK BOLEH 0 ATAU NEGATIF");
            return;
        }
        System.out.print("Jenis Kursus (1. Online / 2. Offline / 3. Bundle) : ");
        String jenisKursus = sc.nextLine().trim();
        
        try{
            PaketKursus paket;
            switch(jenisKursus){
                case "1":
                    paket = new KursusOnline(hargaKursus);
                    break;
                case "2":
                    paket = new KursusOffline(hargaKursus) {
                @Override
                public void cetakInfoPerpanjangan(int hariTambahan) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            };
                    break;
                case "3":
                    paket = new KursusBundle(hargaKursus) {
                @Override
                public void cetakInfoPerpanjangan(int hariTambahan) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            };
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");
                    return;
            }
            Peserta peserta = new Peserta(nama, nomorTelepon);
            daftarPeserta.add(peserta);
            daftarPaketKursus.add(paket);
            System.out.println("BERHASIL : Pesanan Berhasil Ditambahkan");
            
        } catch(DataKursusTidakValidException e){
            System.out.println("ERROR : " + e.getMessage());
        }
    }
    
    static void rekapPeserta(){
        if(daftarPeserta.isEmpty()){
            System.out.println("\nTidak Ada Pesanan yang Tercatat");
            return;
        }
        
        System.out.println("\n===== REKAP PESANAN =====");
        for(int i = 0; i < daftarPeserta.size(); i++){
            Peserta p = daftarPeserta.get(i);
            PaketKursus paket = daftarPaketKursus.get(i);
            
            System.out.println("Peserta     : " + p.getNama());
            System.out.println("Paket       : " + paket.getNamaKursus());
            System.out.printf("Total       : Rp %,.0f%n", paket.hitungTotalBiaya());
            
            if(paket instanceof Perpanjang){
                System.out.print("Perpanjang      : ");
                ((Perpanjang) paket).cetakInfoPerpanjangan(30);
            } else {
                System.out.println("Perpanjang      : Tidak Tersedia");
            }
            System.out.println("==========================================");
            
        }
        System.out.println("=========================================");
            
    }
    
}

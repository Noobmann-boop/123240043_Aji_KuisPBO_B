/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studikita;

/**
 *
 * @author Lab Informatika
 */
public abstract class KursusOffline extends PaketKursus implements Perpanjang {
    public KursusOffline(double hargaKursus) throws DataKursusTidakValidException{
        super("Kursus Offline", hargaKursus);
    }
    @Override
    public double hitungTotalBiaya(){
        return getHargaKursus() + 50000;
    }
    
    public double cetakInfoPerpanjang(int hariTambahan){
        return getHargaKursus() * 0.1 * hariTambahan;
    }
}

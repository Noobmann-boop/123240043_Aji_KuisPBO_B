/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studikita;

/**
 *
 * @author Lab Informatika
 */
public abstract class KursusBundle extends PaketKursus implements Perpanjang{
    public KursusBundle(double hargaKursus) throws DataKursusTidakValidException {
        super("Kursus Bundle", hargaKursus);
    }
    @Override
    public double hitungTotalBiaya(){
        return getHargaKursus() + 150000;
    }
    
    public double cetakInfoPerpanjang(int hariTambahan){
        return getHargaKursus() * 0.2 * hariTambahan;
    }
}

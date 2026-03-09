/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studikita;

/**
 *
 * @author Lab Informatika
 */
public abstract class PaketKursus {
    private String namaKursus;
    private double hargaKursus;
    
    public PaketKursus(String namaKursus, double hargaKursus) throws DataKursusTidakValidException{
        if (hargaKursus <= 0) {
            throw new DataKursusTidakValidException("Tidak Boleh 0 atau Negatif");
        }
        this.namaKursus = namaKursus;
        this.hargaKursus = hargaKursus;
    }

    public String getNamaKursus() {
        return namaKursus;
    }

    public double getHargaKursus() {
        return hargaKursus;
    }
    
    public abstract double hitungTotalBiaya();
}

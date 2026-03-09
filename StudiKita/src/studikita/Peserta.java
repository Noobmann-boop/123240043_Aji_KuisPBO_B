/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studikita;

/**
 *
 * @author Lab Informatika
 */
public class Peserta {
    private String idPeserta;
    private String nama;
    private String nomorTelepon;
    private static int counter = 1;
    
    public Peserta(String nama, String nomorTelepon){
        this.idPeserta = String.format("S%03d", counter++);
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
    }

    public String getIdPeserta() {
        return idPeserta;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }
    
    
}

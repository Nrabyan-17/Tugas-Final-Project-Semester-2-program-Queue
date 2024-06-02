package bp2.tugas.fp;

import java.util.Scanner;

public class mainApp {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        cDaftarTransaksi jual = new cDaftarTransaksi();//untuk antrian toko
        cTransaksi trx = null;

        //barang yang dijual Angkringan Sederhana
        cBarang brg1 = new cBarang("Sate Ayam", 12000);
        cBarang brg2 = new cBarang("Tahu", 4000);
        cBarang brg3 = new cBarang("Tempe", 4000);
        cBarang brg4 = new cBarang("Es Teh", 5000);
        cBarang brg5 = new cBarang("Es Jeruk", 7000);
        
        //member Angkringan Sederhana
        int idmem1=100, pin1=111;
        int idmem2=101, pin2=222;
        int idmem3=102, pin3=333;
        int id,pin;
        
        int pilih, pilih2, pilih3,pilih4,pilih5 = 0;
        int jumlah = 0;
        int kode = 0; // Pindahkan inisialisasi di sini

        do{
            System.out.println("");
            System.out.println("================ANGKRINGAN SEDERHANA================");
            System.out.println("1. Pembeli");
            System.out.println("2. Member");
            System.out.println("3. Admin");
            System.out.println("4. Owner");
            System.out.println("5. Program selesai");
            System.out.print("Anda ingin masuk sebagai apa?: ");
            pilih = scn.nextInt();
            System.out.println("====================================================\n");

            switch(pilih){
                case 1: // ---> PEMBELI
                    kode++; // kode transaksi bertambah setiap kali memulai transaksi baru
                    cDaftarTransaksi beli = new cDaftarTransaksi();//untuk pembelian
                    System.out.print("Masukkan Nama: ");
                    String nm = scn.next();

                    do{
                        System.out.println("");
                        System.out.println("----Akun Pembeli---");
                        System.out.println("1. Tambah");
                        System.out.println("2. Hapus");
                        System.out.println("3. Lihat");
                        System.out.println("4. Selesai");
                        System.out.print("Pilih: ");
                        pilih2 = scn.nextInt();

                        switch(pilih2){
                            case 1:
                                System.out.println("");
                                System.out.println("----Daftar Menu----");
                                System.out.println("1. Sate Ayam");
                                System.out.println("2. Tahu");
                                System.out.println("3. Tempe");
                                System.out.println("4. Es Teh");
                                System.out.println("5. Es Jeruk");
                                System.out.print("Pilih: ");
                                pilih3 = scn.nextInt();
                                System.out.print("Jumlah: ");
                                jumlah = scn.nextInt();

                                if(pilih3==1){
                                    trx = new cTransaksi(String.valueOf(kode), nm, brg1, jumlah, "Belum diproses");
                                }else if(pilih3==2){
                                    trx = new cTransaksi(String.valueOf(kode), nm, brg2, jumlah, "Belum diproses");
                                }else if(pilih3==3){
                                    trx = new cTransaksi(String.valueOf(kode), nm, brg3, jumlah, "Belum diproses");
                                }else if(pilih3==4){
                                    trx = new cTransaksi(String.valueOf(kode), nm, brg4, jumlah, "Belum diproses");
                                }else if(pilih3==5){
                                    trx = new cTransaksi(String.valueOf(kode), nm, brg5, jumlah, "Belum diproses");
                                }else{
                                    System.out.println("Pilihan tidak valid.");
                                }
                                if(trx!=null){
                                    beli.tambah(trx);
                                }
                                break;

                            case 2:
                                beli.lihat();
                                System.out.print("Hapus Nomor= ");
                                int hapus = scn.nextInt();
                                beli.hapus(hapus);
                                break;

                            case 3:
                                beli.lihat();
                                break;

                            case 4:
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                System.out.println("Transaksi selesai.");
                                break;

                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    } while(pilih2!=4);
                    break;

                case 2: // ---> member
                    boolean ketemu = false;
                    do {
                        System.out.print("ID Member: ");
                        id = scn.nextInt();
                        System.out.print("Pin : ");
                        pin = scn.nextInt();

                        if (id == idmem1 && pin == pin1)
                            ketemu = true;
                        else if (id == idmem2 && pin == pin2)
                            ketemu = true;
                        else if (id == idmem3 && pin == pin3)
                            ketemu = true;
                        if (ketemu==false)
                            System.out.println("ID/Pin yang dimasukkan salah!!");
                        else break;
                    } while (ketemu==false);
                    if(ketemu==true){
                        System.out.println("");
                        System.out.println("Selamat Datang!!");
                        kode++;
                        beli = new cDaftarTransaksi();
                        do {
                            System.out.println("");
                            System.out.println("----Akun Member---");
                            System.out.println("1. Tambah");
                            System.out.println("2. Hapus");
                            System.out.println("3. Lihat");
                            System.out.println("4. Selesai");
                            System.out.print("Pilih: ");
                            pilih4 = scn.nextInt();

                            switch (pilih4) {
                                case 1:
                                    System.out.println("");
                                    System.out.println("----Daftar Menu----");
                                    System.out.println("1. Sate Ayam");
                                    System.out.println("2. Tahu");
                                    System.out.println("3. Tempe");
                                    System.out.println("4. Es Teh");
                                    System.out.println("5. Es Jeruk");
                                    System.out.print("Pilih: ");
                                    pilih5 = scn.nextInt();
                                    System.out.print("Jumlah: ");
                                    jumlah = scn.nextInt();
                                    if(pilih5== 1) {
                                        trx = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg1, jumlah, "Belum diproses");
                                    }else if(pilih5==2) {
                                        trx = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg2, jumlah, "Belum diproses");
                                    }else if(pilih5==3) {
                                        trx = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg3, jumlah, "Belum diproses");
                                    }else if(pilih5==4) {
                                        trx = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg4, jumlah, "Belum diproses");
                                    }else if (pilih5 == 5) {
                                        trx = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg5, jumlah, "Belum diproses");
                                    }else {
                                        System.out.println("Pilihan tidak valid.");
                                    }
                                    if (trx != null) {
                                        beli.tambah(trx);
                                    }
                                    break;
                                case 2:
                                    beli.lihat();
                                    System.out.print("Hapus Nomor= ");
                                    int hapus = scn.nextInt();
                                    beli.hapus(hapus);
                                    break;
                                case 3:
                                    beli.lihatTransaksiMember();
                                    break;
                                case 4:
                                    jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                    System.out.println("Transaksi selesai.");
                                    break;

                                default:
                                    System.out.println("Pilihan tidak valid.");
                            }
                        } while (pilih4 != 4);
                        }
                        break;

                case 3: // ---> admin
                    System.out.println("----Akun Admin----");
                    jual.lihat();
                    // proses transaksi
                    cTransaksi t = jual.getFront();
                    do {
                        if (t.getStatusTransaksi()=="Belum diproses") {
                            jual.lihatAdmin();
                            System.out.println("1. Proses");
                            System.out.println("2. Selesai");
                            System.out.print("Pilih: ");
                            int pilihtrx = scn.nextInt();

                            if (pilihtrx == 1) {
                                jual.prosesTransaksi(t);
                                System.out.println("Berhasil diproses..");
                            } else {
                                break;
                            }
                            System.out.println("");
                        }
                        t = t.next;
                    } while (t != null);
                    break;

                case 4: // ---> pemilik warung
                    System.out.println("----Akun Owner----");
                    System.out.println("Jumlah Transaksi yang sudah diproses: "+jual.lihatProsesTransaksi());
                    System.out.println("Pemasukan: "+jual.lihatPemasukan());
                    break;

                case 5:
                    System.out.println("Terimakasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 5);
    }
}
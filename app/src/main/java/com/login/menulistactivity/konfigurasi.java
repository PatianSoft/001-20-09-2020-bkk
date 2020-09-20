package com.login.menulistactivity;

public class konfigurasi {
    public static final String URL_GET_ALL_LOKER = "https://febrian001.000webhostapp.com/android/tampilSemuaLoker.php";
    public static final String URL_GET_EMP_DETLOKER = "https://febrian001.000webhostapp.com/admin/tampilLoker.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "id_loker";
    public static final String KEY_EMP_NAMAPER = "nm_perusahaan";
    public static final String KEY_EMP_NAMALOK = "loker";
    public static final String KEY_EMP_KETLOK = "keterangan"; //desg itu variabel untuk posisi
    //public static final String KEY_EMP_ALAMAT = "address"; //salary itu variabel untuk gajih

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id_loker";
    public static final String TAG_NAMA_PER = "nama_per";
    public static final String TAG_NAMA_LOK = "nama_lok";
    public static final String TAG_KETLOK = "keterangan";

    //ID Loker
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
}


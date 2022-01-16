package com.example.stockopnamewarehouse.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

public class PreferenceUtils extends AppCompatActivity {


    public PreferenceUtils() {
    }

    // --------------- DATA PROFILE ---------------


    public static boolean saveIdUser(String iduser, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_ID_USER, iduser);
        prefsEditor.apply();
        return true;
    }

    public static String getIdUser(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.KEY_ID_USER, "");
    }

    public static boolean saveUsername(String username, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_USERNAME, username);
        prefsEditor.apply();
        return true;
    }

    public static String getUsername(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.KEY_USERNAME, "");
    }

    public static boolean savePassword(String password, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_PASSWORD, password);
        prefsEditor.apply();
        return true;
    }

    public static String getPassword(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.KEY_PASSWORD, "");
    }

    public static boolean saveNama(String nama, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_NAMA, nama);
        prefsEditor.apply();
        return true;
    }

    public static String getNama(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.KEY_NAMA, "");
    }

    public static boolean saveIdRole(String idrole, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_ID_ROLE, idrole);
        prefsEditor.apply();
        return true;
    }

    public static String getIdRole(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.KEY_ID_ROLE, "");
    }



    // --------------- DATASISWA/GURU ---------------


    /*public static boolean saveIdSiswa(String idsiswa, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_ID_MURID, idsiswa);
        prefsEditor.apply();
        return true;
    }

    public static String getIdSiswa(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_ID_MURID, null);
    }

    public static boolean saveIdGuru(String idguru, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_ID_GURU, idguru);
        prefsEditor.apply();
        return true;
    }

    public static String getIdGuru(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_ID_GURU, null);
    }

    public static boolean saveUserId(String userid, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_USER_ID, userid);
        prefsEditor.apply();
        return true;
    }

    public static String getUserId(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_USER_ID, null);
    }

    public static boolean saveIdSekolahSiswa(String idsekolahsiswa, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_ID_SEKOLAH_SISWA, idsekolahsiswa);
        prefsEditor.apply();
        return true;
    }

    public static String getIdSekolahSiswa(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_ID_SEKOLAH_SISWA, null);
    }


    public static boolean saveIdSekolahGuru(String idsekolahguru, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_ID_SEKOLAH_GURU, idsekolahguru);
        prefsEditor.apply();
        return true;
    }

    public static String getIdSekolahGuru(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_ID_SEKOLAH_GURU, null);
    }

    public static boolean saveIdKelas(String idkelas, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_KELAS_ID, idkelas);
        prefsEditor.apply();
        return true;
    }

    public static String getIdKelas(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_KELAS_ID, null);
    }



    public static boolean saveFirstName(String firstname, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_FIRST_NAME, firstname);
        prefsEditor.apply();
        return true;
    }

    public static String getFirstName(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_FIRST_NAME, "");
    }

    public static boolean saveMidName(String midname, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_MID_NAME, midname);
        prefsEditor.apply();
        return true;
    }

    public static String getMidName(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_MID_NAME, "");
    }

    public static boolean saveLastName(String lastname, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_LAST_NAME, lastname);
        prefsEditor.apply();
        return true;
    }

    public static String getLastName(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_LAST_NAME, "");
    }

    public static boolean saveNis(String nis, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_NIS, nis);
        prefsEditor.apply();
        return true;
    }

    public static String getNis(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_NIS, "");
    }

    public static boolean saveStatus(String status, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_STATUS, status);
        prefsEditor.apply();
        return true;
    }

    public static String getStatus(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_STATUS, null);
    }

    public static boolean saveTtl(String ttl, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_TTL, ttl);
        prefsEditor.apply();
        return true;
    }

    public static String getTtl(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_TTL, null);
    }

    public static boolean saveJk(String jk, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_GENDER, jk);
        prefsEditor.apply();
        return true;
    }

    public static String getJk(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_GENDER, null);
    }

    public static boolean saveReligion(String religion, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_RELIGION, religion);
        prefsEditor.apply();
        return true;
    }

    public static String getReligion(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_RELIGION, null);
    }


    public static boolean saveProvince(String province, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_PROVINCE, province);
        prefsEditor.apply();
        return true;
    }

    public static String getProvince(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_PROVINCE, null);
    }

    public static boolean saveCity(String city, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_CITY, city);
        prefsEditor.apply();
        return true;
    }

    public static String getCity(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_CITY, null);
    }

    public static boolean saveDistrict(String district, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_DISTRICT, district);
        prefsEditor.apply();
        return true;
    }

    public static String getDistrict(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_DISTRICT, null);
    }

    public static boolean saveVillage(String village, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_VILLAGE, village);
        prefsEditor.apply();
        return true;
    }

    public static String getVillage(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_VILLAGE, null);
    }
    public static boolean saveAddress(String address, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_ADDRESS, address);
        prefsEditor.apply();
        return true;
    }

    public static String getAddress(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_ADDRESS, null);
    }

    public static boolean savePostalCode(String postalcode, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KET_POSTAL_CODE, postalcode);
        prefsEditor.apply();
        return true;
    }

    public static String getPostalCode(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KET_POSTAL_CODE, null);
    }

    public static boolean saveEmail(String email, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_EMAIL, email);
        prefsEditor.apply();
        return true;
    }

    public static String getEmail(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_EMAIL, null);
    }


    public static boolean saveTlp(String tlp, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_PHONE, tlp);
        prefsEditor.apply();
        return true;
    }

    public static String getTlp(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_PHONE, null);
    }

    public static boolean saveNik(String nik, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_NIK, nik);
        prefsEditor.apply();
        return true;
    }

    public static String getNik(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_NIK, null);
    }

    public static boolean saveNip(String nip, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_NIP, nip);
        prefsEditor.apply();
        return true;
    }

    public static String getNip(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_NIP, null);
    }

    public static boolean savePhotoSiswa(String photosiswa, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_IMAGE_SISWA, photosiswa);
        prefsEditor.apply();
        return true;
    }

    public static String getPhotoSiswa(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_IMAGE_SISWA, null);
    }

    public static boolean savePhotoGuru(String photoguru, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_IMAGE_GURU, photoguru);
        prefsEditor.apply();
        return true;
    }

    public static String getPhotoGuru(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_IMAGE_GURU, null);
    }*/



    // --------------- DATASEKOLAH ---------------


  /*  public static boolean saveSekolahId(String sekolah_id, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.SEKOLAH_ID, sekolah_id);
        prefsEditor.apply();
        return true;
    }

    public static String getSekolahId(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.SEKOLAH_ID, null);
    }

    public static boolean saveSekolahNama(String sekolah_nama, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.SEKOLAH_NAMA, sekolah_nama);
        prefsEditor.apply();
        return true;
    }

    public static String getSekolahNama(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.SEKOLAH_NAMA, null);
    }

    public static boolean saveSekolahAlamat(String sekolah_alamat, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.SEKOLAH_ALAMAT, sekolah_alamat);
        prefsEditor.apply();
        return true;
    }

    public static String getSekolahAlamat(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.SEKOLAH_ALAMAT, null);
    }

    public static boolean saveSekolahPhone(String sekolah_phone, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.SEKOLAH_PHONE, sekolah_phone);
        prefsEditor.apply();
        return true;
    }

    public static String getSekolahPhone(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.SEKOLAH_PHONE, null);
    }

    public static boolean saveSekolahWebsite(String sekolah_website, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.SEKOLAH_WEBSITE, sekolah_website);
        prefsEditor.apply();
        return true;
    }

    public static String getSekolahWebsite(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.SEKOLAH_WEBSITE, null);
    }

    public static boolean saveSekolahEmail(String sekolah_email, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.SEKOLAH_EMAIL, sekolah_email);
        prefsEditor.apply();
        return true;
    }

    public static String getSekolahEmail(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.SEKOLAH_EMAIL, null);
    }*/


    // ----------------- DATA KELAS ----------------


   /* public static boolean saveKelasId(String kelas_id, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KELAS_ID, kelas_id);
        prefsEditor.apply();
        return true;
    }

    public static String getKelasId(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KELAS_ID, null);
    }

    public static boolean saveKelasNama(String kelas_nama, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KELAS_NAMA, kelas_nama);
        prefsEditor.apply();
        return true;
    }

    public static String getKelasNama(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KELAS_NAMA, null);
    }*/


    // ----------------- IMAGE BITMAP ---------------

    /*

    // method for bitmap to base64
    public static String encodeTobase64(Bitmap image) {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        Log.d("Image Log:", imageEncoded);
        return imageEncoded;
    }

    public static boolean savePhotoSiswa(String namaimage, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.NAMA_IMAGE_SISWA, namaimage);
        //prefsEditor.putString(Constants.KEY_IMAGE_SISWA, encodeTobase64(image));
        prefsEditor.commit();
        return true;
    }

    public static String getPhotoSiswa(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.KEY_IMAGE_SISWA, null);
    }

    // method for base64 to bitmap (decode base64)
    public static Bitmap getPhotoSiswa(Context context) {
        byte[] decodedByte = Base64.decode(Constants.KEY_IMAGE_SISWA, 0);
        return BitmapFactory
                .decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    public static boolean savePhotoGuru(String namaimage, Bitmap image, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.NAMA_IMAGE_GURU, namaimage);
        prefsEditor.putString(Constants.KEY_IMAGE_GURU, encodeTobase64(image));
        prefsEditor.commit();
        return true;
    }

    // method for base64 to bitmap (decode base64)
    public static Bitmap getPhotoGuru(Context context) {
        byte[] decodedByte = Base64.decode(Constants.KEY_IMAGE_GURU, 0);
        return BitmapFactory
                .decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    */


    // ----------------- LIST PORTFOLIO ---------------

    /*public static boolean saveNamaMapel(String nama_mapel, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(com.project.eportfolio.utility.Constants.KEY_NAMA_MAPEL, nama_mapel);
        prefsEditor.apply();
        return true;
    }

    public static String getNamaMapel(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(com.project.eportfolio.utility.Constants.KEY_NAMA_MAPEL, null);
    }*/

}

package com.example.stockopnamewarehouse.utility;

public class Constants {

    // --------------- DATA MURID / GURU ---------------

    public static String KEY_ID_USER = "iduser";
    public static String KEY_NAMA = "nama";
    public static String KEY_USERNAME = "username";
    public static String KEY_PASSWORD = "password";
    public static String KEY_ID_ROLE = "idrole";

    // --------------- DATA MURID / GURU ---------------

/*    public static String KEY_ID_GURU = "idguru";
    public static String KEY_ID_MURID = "idmurid";
    public static String KEY_USER_ID = "userid";
    public static String KEY_ID_SEKOLAH_SISWA = "idsekolahsiswa";
    public static String KEY_ID_SEKOLAH_GURU = "idsekolahguru";
    public static String KEY_KELAS_ID = "kelasid";
    public static String KEY_FIRST_NAME = "firstname";
    public static String KEY_MID_NAME = "midname";
    public static String KEY_LAST_NAME = "lastname";
    public static String KEY_NIS = "nis";
    public static String KEY_GENDER = "gender";
    public static String KEY_TTL = "ttl";
    public static String KEY_RELIGION = "religion";
    public static String KEY_PROVINCE = "province";
    public static String KEY_CITY = "city";
    public static String KEY_DISTRICT = "district";
    public static String KEY_VILLAGE = "village";
    public static String KEY_ADDRESS = "address";
    public static String KET_POSTAL_CODE = "postalcode";
    public static String KEY_PHONE = "phone";
    public static String KEY_EMAIL = "email";
    //public static String KEY_PHOTO = "photo";
    public static String KEY_CREATED_BY = "createdby";
    public static String KEY_CREATED_DATE = "createddate";
    public static String KEY_UPDATE_BY = "updateby";
    public static String KEY_UPDATE_DATE = "updatedate";
    public static String KEY_IS_ACTIVE = "isactive";
    public static String KEY_NIK = "nik";
    public static String KEY_NIP = "nip";*/

    // --------------- DATASEKOLAH ---------------

    /*public static String SEKOLAH_ID = "sekolah_id";
    public static String SEKOLAH_NAMA = "sekolah_nama";
    public static String SEKOLAH_ALAMAT = "sekolah_alamat";
    public static String SEKOLAH_PHONE = "sekolah_phone";
    public static String SEKOLAH_WEBSITE = "sekolah_website";
    public static String SEKOLAH_EMAIL = "sekolah_email";*/

    // -------------- DATA KELAS -----------------

   /* public static String KELAS_ID = "kelas_id";
    public static String KELAS_NAMA = "kelas_nama";
*/

    // ---------------- IMAGE --------------------

  /*  public static String KEY_IMAGE_SISWA = "image_siswa";
    public static String NAMA_IMAGE_SISWA = "nama_image_siswa";
    public static String KEY_IMAGE_GURU = "image_guru";
    public static String NAMA_IMAGE_GURU = "nama_image_guru";


    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";
*/

    // ---------------- LISTPORTFOLIO --------------------

    /*public static String KEY_NAMA_MAPEL = "nama_mapel";

    public static final class HTTP {
        public static final String BASE_URL = "https://eportofolio.id/uploads/tr_portofolio/";
    }*/


    public static final class DATABASE {

        public static final String DB_NAME = "portfolio";
        public static final int DB_VERSION = 1;
        public static final String TABLE_NAME = "sunjukkarya";

        public static final String DROP_QUERY = "DROP TABLE IF EXIST " + TABLE_NAME;

        public static final String GET_PORTFOLIO_QUERY = "SELECT * FROM " + TABLE_NAME;

        public static final String ID = "id";
        public static final String MURIDID = "muridid";
        public static final String GURUID = "guruid";
        public static final String MAPELID = "mapelid";
        public static final String IDKATEGORI = "idkategori";
        public static final String STRATEGIID = "strategiid";
        public static final String RUBRIKID = "rubrikid";
        public static final String JUDUL_KD = "judul_kd";
        public static final String RUBRIKDESK = "rubrikdesk";
        public static final String TANGGAL = "tanggal";
        public static final String TEMPAT = "tempat";
        public static final String NILAI = "nilai";
        public static final String PREDIKAT_MUTU = "predikat_mutu";
        public static final String NARASI = "narasi";
        public static final String FOTO = "foto";
        public static final String KELAS = "kelas";
        public static final String TH_AJARAN = "th_ajaran";
        public static final String SEMESTER = "semester";
        public static final String CREATEDBY = "createdby";
        public static final String CREATEDDATE = "createddate";
        public static final String UPDATEBY = "updateby";
        public static final String UPDATEDATE = "updatedate";
        public static final String PREDIKAT = "predikat";
        public static final String KELASID = "kelasid";

        public static final String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "" +
                "(" + ID + " INTEGER PRIMARY KEY not null," +
                MURIDID + " TEXT not null," +
                GURUID + " TEXT not null," +
                MAPELID + " TEXT not null," +
                IDKATEGORI + " TEXT not null," +
                STRATEGIID + " TEXT not null," +
                RUBRIKID + " TEXT not null)," +
                JUDUL_KD + " TEXT not null," +
                RUBRIKDESK + " TEXT not null," +
                TANGGAL + " TEXT not null," +
                TEMPAT + " TEXT not null," +
                NILAI + " TEXT not null," +
                PREDIKAT_MUTU + " TEXT not null)," +
                NARASI + " TEXT not null," +
                FOTO + " TEXT not null," +
                KELAS + " TEXT not null," +
                TH_AJARAN + " TEXT not null," +
                SEMESTER + " TEXT not null," +
                CREATEDBY + " TEXT not null)," +
                CREATEDDATE + " TEXT not null," +
                UPDATEBY + " TEXT not null," +
                UPDATEDATE + " TEXT not null," +
                PREDIKAT + " TEXT not null," +
                KELASID + " TEXT not null";
    }

    public static final class REFERENCE {
        public static final String PORTFOLIO = Config.PACKAGE_NAME + "portfolio";
    }

    public static final class Config {
        public static final String PACKAGE_NAME = "com.project.eportfolio.";
    }
}

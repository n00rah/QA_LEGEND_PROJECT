package constants;

import java.io.File;

public class Constants {
	public static final String TESTDATA_EXCELPATH = "\\src\\main\\resources\\TestData.xlsx";
	public static final String HOME_DIRECTORY = System.getProperty("user.dir");
	public static final String LOGIN_PAGE = "LoginPage";
	public static final String PROFILE_PAGE = "ProfilePage";
	public static final String RESET_PAGE = "ResetPage";
	public static final String ADDUSER_PAGE = "AddUserPage";
	public static final String USERS_PAGE = "UsersPage";
	public static final String USERNAME_EXTENSION = "00";
	public static final String PASSWORD_EXTENSION = "11";
	public static final String MAIL_EXTENSION = "@gmail.com";
	public static final String INSERT_SPACE = " ";
	public static final String CONFIG_FILE = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator + "config.properties";
}

package com.epam.hackme.common;

public interface QueryConstants {
String GET_USER_ID="SELECT USER_ID FROM EPAM_USER where USER_NAME='";
String REGISTER_USER="INSERT INTO CHALLENGE_USER VALUES(?,?,?,?)";
String IS_VALID_USER="SELECT COUNT(*) FROM CHALLENGE_USER WHERE USER_ID=? AND PASSWORD=?";
}

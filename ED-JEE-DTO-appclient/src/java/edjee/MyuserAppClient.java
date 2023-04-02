/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edjee;

import entity.MyuserDTO;
import java.util.ArrayList;
import session.MyuserFacadeRemote;

/**
 *
 * @author ssaleheen
 */
public class MyuserAppClient {
 @javax.ejb.EJB
 private static MyuserFacadeRemote myuserFacade;
 public MyuserAppClient() {
 }
 public static void main(String[] args) {
 MyuserAppClient client = new MyuserAppClient();
 // Create new records
 MyuserDTO myuserDTO = new MyuserDTO("000010", "Peter Smith", "123456", "psmith@swin.edu.au", "9876543210", "Swinburne EN510g", "What is my name?", "Peter"); boolean result = client.createRecord(myuserDTO);
 client.showCreateResult(result, myuserDTO);
 MyuserDTO myuserDTO2 = new MyuserDTO("000012", "David Lee", "654321", "dlee@swin.edu.au", "0123456789", "Swinburne EN510g", "What is my name?", "David");
 result = client.createRecord(myuserDTO2);
 client.showCreateResult(result, myuserDTO2);
 // Get a record
 MyuserDTO foundUser = client.getRecord("000010");
 System.out.println("Found user: " + foundUser.getName());
 MyuserDTO myuserDTOEmulateUpdate = new MyuserDTO("000012", "David Lee", "654321", "dlee@swin.edu.au", "0123456789", "Swinburne EN510g", "What is my name?", "David");
 // Update a record
 result = client.updateRecord(myuserDTOEmulateUpdate);
 System.out.println("Update result: " + result);
 // Delete a record
 result = client.deleteRecord("000006");
 System.out.println("Delete result: " + result);
 // Get records by address
 ArrayList<MyuserDTO> usersWithSameAddress = client.getRecordsByAddress("Swinburne EN510g");
 System.out.println("Users with the same address:"); for (MyuserDTO user : usersWithSameAddress) {
 System.out.println(user.getName());
}
 }
 public void showCreateResult(boolean result, MyuserDTO myuserDTO) {
 if (result) {
 System.out.println("Record with primary key " + myuserDTO.getUserid()
 + " has been created in the database table.");
 } else {
 System.out.println("Record with primary key " + myuserDTO.getUserid()
 + " could not be created in the database table!");
 }
 }
 public Boolean createRecord(MyuserDTO myuserDTO) {
 return myuserFacade.createRecord(myuserDTO);
 }
 public MyuserDTO getRecord(String userId) {
 return myuserFacade.getRecord(userId);
 }
 public boolean updateRecord(MyuserDTO myuserDTO) {
 return myuserFacade.updateRecord(myuserDTO);
 }
 public boolean deleteRecord(String userId) {
 return myuserFacade.deleteRecord(userId);
 }
 public ArrayList<MyuserDTO> getRecordsByAddress(String address) {
 return myuserFacade.getRecordsByAddress(address);
 }
}
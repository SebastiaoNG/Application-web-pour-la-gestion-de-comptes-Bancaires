package  org.upec.servlets;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.*;
import java.sql.Date;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.upec.comptes.Account;
import java.text.SimpleDateFormat;
@Path("/api")
public class  UserExposer{
	
	//private static Map<Integer,Account> accounts = new HashMap<Integer,Account>();
	@Path("GetAccounts")
	@GET
	@Produces("application/json")
	public Response getAccounts() throws JSONException, ClassNotFoundException, SQLException {
		
		AccountDAO Adao = new AccountDAO();//get the list de données sur la table Account sql server
		ArrayList<Account> accounts = Adao.getAllAccount();
		
		//Convert users to a JSON object
		JSONArray jsonAccounts = new JSONArray();
		for(int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			JSONObject jsonUser = new JSONObject();
			jsonUser.put("AcountNumber", account.getAcountNumber());
			jsonUser.put("Solde", account.getSolde());
			jsonUser.put("creationDate ", account.getCreationDate() );
			jsonUser.put("idCustomer", account.getIdCustomer());
			jsonAccounts.put(jsonUser);
		}
		String result = "" + jsonAccounts;
		return Response.status(200).entity(result).build();
	}

	//ADD A ACCOUNT 
	@Path("AddAccounts")
	@POST	
	@Consumes("application/json")
	@Produces("application/json")	
	public Response addUser(InputStream jUserStream) throws ClassNotFoundException, SQLException, java.text.ParseException {
		
		JSONParser jsonParser = new JSONParser();
		org.json.simple.JSONObject jsonObject; 
		System.out.println(jsonParser);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			jsonObject = (org.json.simple.JSONObject)jsonParser.parse(
			      new InputStreamReader(jUserStream, "UTF-8"));
			System.out.println(jsonObject);  //ok 
			/*String solde = (String)jsonObject.get("solde");//
			System.out.print(" solde---->" + solde+"\n");
			String acountNumber = (String)jsonObject.get("acountNumber");//
			System.out.print("accountNumber. ---->" + acountNumber+"\n");*/
			
			String t = (String)jsonObject.get("creationDate");//não consegue ler data
			System.out.print("---->" + t);
			java.util.Date date1= formatter.parse(t); 
			
			Account account = new Account(
										Integer.parseInt((String)jsonObject.get("accountNumber")), 
										Float.parseFloat((String)jsonObject.get("solde")), 
										date1);
			//Account account = new Account(Integer.parseInt((String)jsonObject.get("accountNumber")), 
			//		Double.parseDouble((String)jsonObject.get("solde")), 
			//		Date.parseDate((String)jsonObject.get("d1")));
			
			//System.out.println(accounts);
			AccountDAO Adao = new AccountDAO();
			Adao.AddAccount(account);  //ajouter une compte
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		String result = "{'données ajoutées success':1}" ;
		return Response.status(200).entity(result).build();		
	}


	/**/
	//delete
	@Path("/{accountNumber}")
    @DELETE
	@Consumes("application/json")
	@Produces("application/json")	
	public Response DeleteAccount(InputStream jUserStream) throws java.text.ParseException, ClassNotFoundException, SQLException {
		
		JSONParser jsonParser = new JSONParser();
		org.json.simple.JSONObject jsonObject;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			jsonObject = (org.json.simple.JSONObject)jsonParser.parse(
			      new InputStreamReader(jUserStream, "UTF-8"));
			System.out.println(jsonObject);
			String t = (String)jsonObject.get("creationDate");//não consegue ler data
			//System.out.print("---->" + t);
			java.util.Date date1= formatter.parse(t); 
			Account account = new Account(
										Integer.parseInt((String)jsonObject.get("accountNumber")), 
										Float.parseFloat((String)jsonObject.get("solde")), 
										date1);
	
			//System.out.println("object: "+account);
			AccountDAO Adao = new AccountDAO();
			Adao.DeleteAccount(account);
		} catch (UnsupportedEncodingException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}			
		String result = "{'Delete success':1}" ;
		return Response.status(200).entity(result).build();		
	}
	
	//Mise á jour
	@Path("/{updateAccount}")
	@PUT
	@Consumes("application/json")
	@Produces("application/json")	
	public Response UpdateAccount(InputStream jUserStream) throws ClassNotFoundException, SQLException, java.text.ParseException {	
		JSONParser jsonParser = new JSONParser();
		org.json.simple.JSONObject jsonObject;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			jsonObject = (org.json.simple.JSONObject)jsonParser.parse(
			      new InputStreamReader(jUserStream, "UTF-8"));
			System.out.println(jsonObject);
			String id = (String)jsonObject.get("accountNumber");
			String sold = (String)jsonObject.get("solde");
			System.out.print("account number--->" + id+"\n");
			System.out.print("Solde--->" + sold+"\n");
			
			String t = (String)jsonObject.get("creationDate");
			System.out.print("date---->" + t);
			java.util.Date date1= formatter.parse(t); 
			Account account = new Account(
										Integer.parseInt((String)jsonObject.get("accountNumber")), 
									    Float.parseFloat((String)jsonObject.get("solde")), 
										date1);
			//System.out.println(account);
			//System.out.println(accounts);
			AccountDAO Adao = new AccountDAO();
			Adao.updateAccount(account);  //ajouter une compte
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		String result = "{'UPDATE success':1}" ;
		return Response.status(200).entity(result).build();		
	}
//-------------------------------------------------------------------------------------------------------
	// GET ID COMPTE DATA 
	/*@Path("/GetAccountsID")
	@GET
	@Produces("application/json")
	public Response getID_Accounts() throws JSONException, ClassNotFoundException, SQLException {
		
		AccountDAO Adao = new AccountDAO();//get the list de données sur la table Account sql server
		ArrayList<Account> accounts = Adao.getAllAccount();
		
		//Convert users to a JSON object
		JSONArray jsonAccounts = new JSONArray();
		for(int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			JSONObject jsonUser = new JSONObject();
			jsonUser.put("AcountNumber", account.getAcountNumber());
			jsonUser.put("Solde", account.getSolde());
			jsonUser.put("creationDate ", account.getCreationDate() );
			jsonAccounts.put(jsonUser);
		}
		String result = "" + jsonAccounts;
		return Response.status(200).entity(result).build();
	}
//---------------------------------------------------------------------------------------------------------	
	*/
	
}

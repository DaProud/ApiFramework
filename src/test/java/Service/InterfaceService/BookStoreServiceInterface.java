package Service.InterfaceService;

import ObjectData.RequestObject.RequestAccountBooks;
import io.restassured.response.Response;

public interface BookStoreServiceInterface {

    // aceasta interfata reprezinta actiunile pe care serviciul BookStore le poate face
    Response addBooksToAccount(RequestAccountBooks body, String token);

}

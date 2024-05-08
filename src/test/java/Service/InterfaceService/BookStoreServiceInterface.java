package Service.InterfaceService;

import ObjectData.RequestObject.RequestAccountBooks;
import ObjectData.RequestObject.RequestAccountBook;
import io.restassured.response.Response;

public interface BookStoreServiceInterface {

    // aceasta interfata reprezinta actiunile pe care serviciul BookStore le poate face
    Response addBooksToAccount(RequestAccountBooks body, String token);

    // TODO: DE IMPLEMENTAT DATA VIITOARE!
    Response updateSpecificBook(RequestAccountBook body, String token, String actualBook);
    Response deleteSpecificBook(RequestAccountBook body, String token);
    Response deleteBooks(String token, String userId);

}

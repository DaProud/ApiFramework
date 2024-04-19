package Tests;

import Actions.AccountActions;
import ObjectData.RequestObject.RequestAccount;
import ObjectData.ResponseObject.ResponseAccountGetSuccess;
import ObjectData.ResponseObject.ResponseAccountSuccess;
import ObjectData.ResponseObject.ResponseTokenSuccess;
import PropertyUtility.PropertyUtility;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import hooks.Hooks;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends Hooks {
    public String userId;
    public String token;
    public RequestAccount requestAccountBody;
    public AccountActions accountActions;

    @Test
    public void testMethod() {
        System.out.println("Step 1: Create new account");
        createAccount();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user creates a new account with success");

        System.out.println("Step 2: Generate new token");
        generateToken();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user generates a token for new account with success");

        System.out.println("Step 3: Get new account");
        getSpecificAccount();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user validates the presence of new account with success");

        System.out.println("Step 4: Delete new account");
        deleteSpecificAccount();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user deletes the new account with success");

        System.out.println("Step 5: Re-check deleted account");
        getSpecificAccount();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user validates the presence of deleted account with success");
    }

    public void createAccount() {
        accountActions = new AccountActions();
        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData");
        requestAccountBody = new RequestAccount(propertyUtility.getAllData());
        ResponseAccountSuccess responseAccountBody = accountActions.createNewAccount(requestAccountBody);
        userId = responseAccountBody.getUserID();
    }

    public void generateToken() {
        ResponseTokenSuccess responseTokenSuccess = accountActions.generateToken(requestAccountBody);
        token = responseTokenSuccess.getToken();
    }

    public void getSpecificAccount() {
        accountActions.getSpecificAccount(token, userId, requestAccountBody);
    }

    public void deleteSpecificAccount() {
        accountActions.deleteSpecificAccount(token, userId);
    }

}

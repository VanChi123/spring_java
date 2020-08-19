package vn.fis.project.springbootfinaltest.controller.message;

import vn.fis.project.springbootfinaltest.appconstant.AppConstant;

public class ErrorResponse extends AppResponse {

    public ErrorResponse(){
        this.setStatus(AppConstant.RESULT_ERROR);
    }

}

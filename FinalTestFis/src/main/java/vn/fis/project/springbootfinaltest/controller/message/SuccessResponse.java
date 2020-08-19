package vn.fis.project.springbootfinaltest.controller.message;

import vn.fis.project.springbootfinaltest.appconstant.AppConstant;

public class SuccessResponse extends AppResponse {

    public SuccessResponse(){
        this.setStatus(AppConstant.RESULT_SUCCESS);
    }

}

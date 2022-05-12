/*
package EXAM_MODULE2.exception;

import EXAM_MODULE2.model.Account;
import EXAM_MODULE2.util.ValidationUtil;

import java.util.List;

public class CheckId {
    private int id;
    private List<Account> list;

    public CheckId() {
    }

    public CheckId(int id,List<Account>list) throws NotFoundException {
        this.id = id;
        if (!ValidationUtil.isExistsId(id,list)){
            throw new NotFoundException("Not Found ID. Try again");
        }
    }
}
*/

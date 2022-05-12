package EXAM_MODULE2.service;

import EXAM_MODULE2.exception.NotFoundException;
import EXAM_MODULE2.model.Account;
import EXAM_MODULE2.model.PaymentAccount;
import EXAM_MODULE2.model.SavingAccount;
import EXAM_MODULE2.util.ConstantUtil;
import EXAM_MODULE2.util.FileHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankingService {
    private List<Account> accounts;
    private FileHelper fileHelper = new FileHelper();
    public BankingService(){
        accounts=mapToAccount();
    }

    public void create(Account account) {
        //region get lastId
        int lastId = 0;
        if(accounts.size() > 0){
            lastId = accounts.get(accounts.size() - 1).getId();
        }
        //endregion

        account.setId(lastId + 1);
        accounts.add(account);
        fileHelper.write(ConstantUtil.path, Collections.singletonList(account), true);
    }
    private List mapToAccount() {
        List result = new ArrayList();

        List<String> lines = fileHelper.read(ConstantUtil.path);
        for (String line : lines){
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String code = tmp[1];
            String name=tmp[2];
            String opendate=tmp[3];

            if(tmp.length == 6){
                String cardNo = tmp[4];
                Double cash = Double.parseDouble(tmp[5]);
                result.add(new PaymentAccount(id,code,name,opendate,cardNo,cash));
            }
            else {
                Double amount=Double.parseDouble(tmp[4]);
                String dateSaving=tmp[5];
                Double rate = Double.parseDouble(tmp[6]);
                int term =Integer.parseInt(tmp[7]);
                result.add(new SavingAccount(id,code,name,opendate,amount,dateSaving,rate,term));
            }
        }

        return result;
    }

    public List<Account> findAll() {
        return accounts;
    }

    public void delete(int id) throws NotFoundException {
        /*for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getId() == id){
                accounts.remove(i);
                fileHelper.write(ConstantUtil.path, accounts, false);
                return;
            }
        }*/
        if(!accounts.removeIf(e-> e.getId() == id)){
            throw new NotFoundException("ID " + id + " cound not found. ");
        }
        fileHelper.write(ConstantUtil.path, accounts, false);
    }

    public List <Account> searchByName(String name) throws NotFoundException{
        List <Account> result = new ArrayList();
        if(!accounts.stream().anyMatch(e->e.getName().equals(name))){
            throw new NotFoundException("Name: " + name + " cound not found. ");
        }
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getName().contains(name)){
                result.add(accounts.get(i));
            }
        }

        return result;
    }
}

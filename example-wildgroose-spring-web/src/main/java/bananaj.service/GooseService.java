package bananaj.service;

import javax.inject.Named;

@Named
public class GooseService {

    public GooseService() {
    }

    public String getHonk() {
        String returnValue = "GooseService: Honked";
        System.out.println(returnValue);
        return returnValue;
    }

}
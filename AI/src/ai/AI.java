/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;

/**
 *
 * @author supithaweerasinghe
 */
public class AI {

    //Initially select a company
    Company selectCompany(Company[] cmp) {
        Company maxCmp = null;
        int temp1 = -3; //Minimum status
        for (int x = 0; x < cmp.length; x++) {
            int temp2 = cmp[x].getState();
            if (temp1 < temp2) {
                maxCmp = cmp[x];
                temp1 = temp2;
            } else if (temp1 == temp2) {
                maxCmp = cmp[x];
                temp1 = temp2;
            }
        }
        return maxCmp;
    }

    public static void main(String[] args) {
        
        //API Calling
        //Client client = ClientBuilder.newClient();
        //WebTarget target = client.target("https://jsonplaceholder.typicode.com/posts/1");
        //System.out.println(
        //        target.request(MediaType.APPLICATION_JSON).get(String.class)
        //);

        Company x = new Company();
        x.setName("x");
        x.setState(9);
        Company y = new Company();
        y.setName("y");
        y.setState(5);
        Company z = new Company();
        z.setName("z");
        z.setState(8);
        
        Company[] cmpArry = {x,y,z};
        
        AI ai = new AI();
        Company selected = ai.selectCompany(cmpArry);
        System.out.println(selected.getName());
    }

}

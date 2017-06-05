package pl.cyfronet.indigo.rest;

import com.agreemount.EngineFacade;
import com.agreemount.bean.identity.provider.IdentityProvider;
import com.agreemount.slaneg.action.ActionContextFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import pl.cyfronet.indigo.repository.MockMvcSecurityTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by piotr on 18.07.16.
 */

public class RestControllerTest extends MockMvcSecurityTest {

    @Test
    public void testGetUsers() throws Exception {
//        MvcResult result = mockMvc.perform(get("/rest/slam/preferences/test").session(user()))
//                .andExpect(status().isOk()).andReturn();
//
//        String content = result.getResponse().getContentAsString();
//        Assert.assertTrue(content.contains("\"customer\":\"test\""));
    }

    @Autowired
    private ActionContextFactory actionContextFactory;

    @Autowired
    private EngineFacade engineFacade;

    @Autowired
    public IdentityProvider identityProvider;



    private void addSLAEST() throws Exception {

//        HashMap<String, String> urlVariables = new HashMap<String, String>();
//        urlVariables.put("site", "BARI");
//        urlVariables.put("id", "test_document");
//        mockMvc.perform(put("/api/sla", urlVariables).session(user())).andExpect(status().isOk()).andReturn();

//        mockMvc.perform(put("/api/sla", urlVariables).session(user())).andExpect(status().isOk()).andReturn();


//        mockMvc.perform(get("/invoke?actionId=editPublicDragt-second-step-Buy+resources&documentId="+doc.getId()).session(user()))
//               .andExpect(status().isOk()).andReturn()
    }

//    @Test
//    public void testGetSLA() throws Exception {
        // add sla offer
//        MvcResult result = null;
//        addSLAEST();
//        result = mockMvc.perform(put("/pool/create", {id: "testPool", site: "VAL"}).session(user()))
//                .andExpect(status().isOk()).andReturn();
//
//        result = mockMvc.perform(get("/rest/slam/sla/"+sla.getId()).session(user()))
//                .andExpect(status().isOk()).andReturn();
//
//        String content = result.getResponse().getContentAsString();
//    }

    @Test
    public void testPreferences() {

    }

    @Test
    public void testGetSLAs() throws Exception {
        MvcResult result = mockMvc.perform(get("/rest/slam/sla").session(user()))
                .andExpect(status().isOk()).andReturn();

        String content = result.getResponse().getContentAsString();
    }
}

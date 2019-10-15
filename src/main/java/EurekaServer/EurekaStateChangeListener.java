package EurekaServer;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;
//import EurekaServer.MSABotSender;

/*#####################################################
###	2019/10/14										###
###	created by jimting								###
###	for Cinema project, and my graduate paper QAQ	###
#######################################################*/

@Component
public class EurekaStateChangeListener 
{
	@Autowired
	private Environment env;
	
	//@Value("${msabot.slackroom}")
    private String roomID = env.getProperty("msabot.slackroom");
	private MSABotSender sender = new MSABotSender();
	
	@EventListener
    public void listen(EurekaInstanceCanceledEvent event) 
	{
        //Service's disconnection event
        String appName = event.getAppName();
        String serverId = event.getServerId();
        System.out.println(">>>>>>>>>>>>>>> Service Failed : " + serverId + " , already removed!");
		sender.send(roomID, appName.toString(), "Failed");
    }
 
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) 
	{
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.out.println(instanceInfo);
    }
 
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) 
	{
        event.getAppName();
        event.getServerId();
    }
 
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) 
	{
		System.out.println(">>>>>>>>>>>>>>>Server Registry Start! ");
		sender.send(roomID, "Eureka Server", "Server Registry Start");
    }
 
    @EventListener
    public void listen(EurekaServerStartedEvent event) 
	{
        //Server start
		System.out.println(">>>>>>>>>>>>>>> Server Start! ");
		sender.send(roomID, "Eureka Server", "Server Start");
    }
}
package EurekaServer;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateChangeListener 
{

	@EventListener
    public void listen(EurekaInstanceCanceledEvent event) 
	{
        //Service's disconnection event
        String appName = event.getAppName();
        String serverId = event.getServerId();
        System.out.println(">>>>>>>>>>>>>>> Service Failed :{},already removed! : ", serverId);
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
		System.out.println(">>>>>>>>>>>>>>>Instance Renewed! : " + event);
    }
 
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) 
	{
		System.out.println(">>>>>>>>>>>>>>>Server Registry Start! : " + event);
    }
 
    @EventListener
    public void listen(EurekaServerStartedEvent event) 
	{
        //Server start
		System.out.println(">>>>>>>>>>>>>>> Server Start! : " + event);
    }
}
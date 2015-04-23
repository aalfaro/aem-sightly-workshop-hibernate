package cr.prodigious.aem.sightlyworkshop;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.osgi.context.support.OsgiBundleXmlApplicationContext;

@Component(immediate = true, label = "Sightly Workshop DAO Activator")
public class Activator implements BundleActivator {
	
    private static final Logger LOG = LoggerFactory.getLogger(Activator.class);
    	
	@Activate
	public void start(BundleContext bundleContext) throws Exception {	
		
		OsgiBundleXmlApplicationContext context = new OsgiBundleXmlApplicationContext(new String[] { "META-INF/spring/applcationContext.xml" });
        context.setBundleContext(bundleContext);
        context.refresh();
		
        LOG.info(bundleContext.getBundle().getSymbolicName() + " started");
        
	}
	
	@Deactivate
    public void stop(BundleContext bundleContext) throws Exception {
        LOG.info(bundleContext.getBundle().getSymbolicName() + " stopped");
    }
	
}
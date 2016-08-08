/**
 * Created by oksdud on 08.08.2016.
 */
import java.io.*;
import org.apache.ivy.core.module.descriptor.*;
import org.apache.ivy.core.settings.*;
import org.apache.ivy.plugins.parser.m2.*;
import org.apache.ivy.plugins.parser.xml.*;

public class Ivy2Pom {
    public static void main(String[] args) {
        try {
            System.setOut(System.err);
            File inputFile = new File(args.length > 0 ? args[0] : "ivy.xml");
            File outputFile = new File(args.length > 1 ? args[1] : "pom1.xml");
            XmlModuleDescriptorParser parser = XmlModuleDescriptorParser.getInstance();
            ModuleDescriptor md = parser.parseDescriptor(new IvySettings(), inputFile.toURI().toURL(), false);
            PomModuleDescriptorWriter.write(md, outputFile, new PomWriterOptions());
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
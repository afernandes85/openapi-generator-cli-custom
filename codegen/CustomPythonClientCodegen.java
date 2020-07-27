import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.*;
import org.openapitools.codegen.utils.ProcessUtils;
import com.google.common.base.CaseFormat;

import java.io.File;

public class CustomPythonClientCodegen extends PythonClientCodegen {
    
    @Override
    public void processOpts() {
        super.processOpts();

        String apiPackageDir = packagePath() + File.separatorChar + "api";

        File folder = new File("/local/templates/python");
        File[] files = folder.listFiles();
        for (File file : files)
        {
            System.out.println(file.getName());
            if(file.getName().endsWith("_doc.mustache")) {
                String outFilename = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, file.getName().substring(0, file.getName().indexOf("_doc.mustache"))) + ".md";
                supportingFiles.add(new SupportingFile(file.getName(), apiDocPath, outFilename));
            }
            else {
                String outFilename = file.getName().substring(0, file.getName().indexOf(".mustache")) + ".py";
                supportingFiles.add(new SupportingFile(file.getName(), apiPackageDir, outFilename));
            }
        }
    }
}
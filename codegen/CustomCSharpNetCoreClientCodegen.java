import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.*;
import org.openapitools.codegen.utils.ProcessUtils;
import com.google.common.base.CaseFormat;

import java.io.File;

public class CustomCSharpNetCoreClientCodegen extends CSharpNetCoreClientCodegen {
    
    @Override
    public void processOpts() {
        super.processOpts();

        String packageFolder = sourceFolder + File.separator + packageName;
        String apiPackageDir = packageFolder + File.separator + apiPackage;

        File folder = new File("/local/dotnet/Templates");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
                if (file.getName().endsWith("_doc.mustache")) {
                    String outFilename = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, file.getName().substring(0, file.getName().indexOf("_doc.mustache"))) + ".md";
                    supportingFiles.add(new SupportingFile(file.getName(), apiDocPath, outFilename));
                } else {
                    String outFilename = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, file.getName().substring(0, file.getName().indexOf(".mustache"))) + ".cs";
                    supportingFiles.add(new SupportingFile(file.getName(), apiPackageDir, outFilename));
                }
            }
        }
    }
}
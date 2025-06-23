package pages.HTMLTagExamplesPages;

import com.codeborne.selenide.Selenide;
import pages.interfaces.Pages;

public class DynamicTableTestPage implements Pages<DynamicTableTestPage> {
    @Override
    public DynamicTableTestPage initPage() {
        Selenide.open("tag/dynamic-table.html");
        System.out.println(Selenide.title());
        return this;
    }
}

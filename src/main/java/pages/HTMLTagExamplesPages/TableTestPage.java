package pages.HTMLTagExamplesPages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import pages.interfaces.Pages;

import static com.codeborne.selenide.Selenide.$x;

public class TableTestPage implements Pages<TableTestPage> {

    private SelenideElement table;
    private ElementsCollection rows;

    @Override
    public TableTestPage initPage() {
        Selenide.open("tag/table.html");
        System.out.println(Selenide.title());

        table = $x("//table");
        rows = table.$$x("./tbody/tr");

        return this;
    }

    public TableTestPage checkTable() {
        for (SelenideElement row : rows) {
            ElementsCollection cells = row.$$x("./td");

            if (cells.size() >= 2) {
                String name = cells.get(0).getText();
                String age = cells.get(1).getText();
                Assert.assertEquals(name, cells.get(0).getText());
                Assert.assertEquals(age, cells.get(1).getText());
            }
        }
        return this;
    }
}
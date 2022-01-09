package cucumbersaurus.zabon.zabon;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import cucumbersaurus.zabon.gui.GuiBase;

import java.util.Arrays;

public class ZabonMainGui extends GuiBase {

    public ZabonMainGui(@NotNull Player p) { super(p, 54, "메인 메뉴"); }

    @Override
    protected void init(@NotNull Player p) {

        for(int i = 0;i < 54;i++){
            setItem(" ", null ,Material.LIGHT_BLUE_STAINED_GLASS_PANE,1, i,"zabon.background",false);
        }

        setItem("개인통장", Arrays.asList("아래 : 개인 자산 관리"), Material.KNOWLEDGE_BOOK, 1, 4, "zabon.personal", false);
        setItem("총 자산", Arrays.asList("총 자산 확인하기"), Material.COPPER_INGOT, 1, 9*2+1, "zabon.personal.total", false);
        setItem("순 자산", Arrays.asList("순 자산 확인하기"), Material.BRICK, 1, 9*2+3, "zabon.personal.pureTotal", false);
        setItem("부채", Arrays.asList("부채 탭 열기"), Material.NETHERITE_INGOT, 1, 9*2+5, "zabon.personal.debt", false);
        setItem("채권", Arrays.asList("채권 탭 열기"), Material.GOLD_INGOT, 1, 9*2+7, "zabon.personal.stock", false);
        setItem("대출/상환", Arrays.asList("아래 : 대출 관련 탭 열기"), Material.WRITABLE_BOOK, 1, 9*4+4, "zabon.loan", false);
        setItem("대출", Arrays.asList("눌러서 은행 탭으로 이동"), Material.WARPED_SIGN, 1, 9*5+2, "zabon.loan.loan", false);
        setItem("상환", Arrays.asList("눌러서 은행 탭으로 이동"), Material.CRIMSON_SIGN, 1, 9*5+6, "zabon.debt.repay", false);

    }

    @Override
    public void onClick(@NotNull InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        String btn = getValue(e.getRawSlot());

        if(btn==null) return;

        switch (btn){
            case "zabon.personal":
                //효과 없음
                break;
            case "zabon.personal.total":
                //개인 총 자산 표시
                break;
            case "zabon.personal.pureTotal":
                //개인 순 자산 표시
                break;
            case "zabon.personal.debt":
                //개인 빚 표시
                break;
            case "zabon.personal.stock":
                //개인 채권 표시
                break;
            case "zabon.loan":
                //효과 없음
                break;
            case "zabon.loan.loan":
                //대출
                break;
            case "zabon.debt.repay":
                //대출 상환
                break;
            default:
                break;
        }
    }

}

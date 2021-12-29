package cucumbersaurus.zabon.zabon;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import cucumbersaurus.zabon.gui.GuiBase;

import java.util.Arrays;

public class ZabonMainGui extends GuiBase {

    public ZabonMainGui(@NotNull Player p, int guiSize, String guiName) { super(p, 54, "이펙트 선택"); }

    @Override
    protected void init() {
        setItem("개인통장", Arrays.asList("아래 : 개인 자산 관리"), Material.GOLD_INGOT, 1, 0, "zabon.personal", false);
        setItem("총 자산", Arrays.asList("총 자산 확인하기"), Material.EMERALD, 1, 9+1, "zabon.personal.total", false);
        setItem("순 자산", Arrays.asList("순 자산 확인하기"), Material.EMERALD, 1, 9+3, "zabon.personal.pureTotal", false);
        setItem("부채", Arrays.asList("부채 탭 열기"), Material.EMERALD, 1, 9+5, "zabon.personal.debt", false);
        setItem("채권", Arrays.asList("채권 탭 열기"), Material.EMERALD, 1, 9+7, "zabon.personal.stock", false);
        setItem("대출/상환", Arrays.asList("아래 : 대출 관련 탭 열기"), Material.GOLD_INGOT, 1, 9*2, "zabon.loan", false);
        setItem("대출", Arrays.asList("눌러서 은행 탭으로 이동"), Material.EMERALD, 1, 9*3+1, "zabon.loan.loan", false);
        setItem("상환", Arrays.asList("눌러서 은행 탭으로 이동"), Material.EMERALD, 1, 9*3+3, "zabon.debt.repay", false);

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

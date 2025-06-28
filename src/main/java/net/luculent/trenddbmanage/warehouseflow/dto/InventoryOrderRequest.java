package net.luculent.trenddbmanage.warehouseflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryOrderRequest {

    @NotBlank(message = "单据编号不能为空")
    private Integer orderId;

    @NotNull(message = "出入库类型不能为空") // IN or OUT
    @Pattern(regexp = "IN|OUT", message = "类型必须为 IN 或 OUT")
    private String recordType;

    @NotNull(message = "仓库ID不能为空")
    private Integer warehouseId;

    private String operator; // 操作人

    private String remark;

    @NotEmpty(message = "明细不能为空")
    private List<InventoryOrderItemRequest> items; // 多个物品项
}


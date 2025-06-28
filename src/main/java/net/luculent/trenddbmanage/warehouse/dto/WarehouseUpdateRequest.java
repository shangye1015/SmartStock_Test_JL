package net.luculent.trenddbmanage.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseUpdateRequest {

    @NotNull(message = "仓库ID不能为空")
    private Integer id;

    @NotBlank(message = "仓库编号不能为空")
    @Length(max = 32, message = "仓库编号长度不能超过32位")
    private String code;

    @NotBlank(message = "仓库名称不能为空")
    @Length(max = 64, message = "仓库名称长度不能超过64位")
    private String name;

    @Length(max = 128, message = "地址长度不能超过128位")
    private String address;

    @Length(max = 32, message = "负责人姓名不能超过32位")
    private String manager;

    @Pattern(regexp = "^$|^\\+?[0-9\\-]{7,15}$", message = "电话格式不正确")
    private String contactPhone;

    private Integer status; // 可选更新状态
}


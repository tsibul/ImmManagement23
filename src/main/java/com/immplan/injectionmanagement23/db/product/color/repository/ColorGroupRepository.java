package com.immplan.injectionmanagement23.db.product.color.repository;

import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorGroupRepository extends JpaRepository<ColorGroup, Long> {
    ColorGroup findColorGroupByColorGroupId(long colorGroupId);

    List<ColorGroup> findColorGroupByColorGroupActiveOrderByColorGroupName(boolean colorGroupActive);
}

package com.immplan.injectionmanagement23.db.product.color.repository;

import com.immplan.injectionmanagement23.db.product.color.Color;
import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Long> {

    List<Color> findColorByColorGroupOrderByColorCode(ColorGroup colorGroup);
    List<Color> findColorByColorGroupColorGroupId(long colorGroupId);
}

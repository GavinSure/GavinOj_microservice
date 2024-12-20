package com.Gavin.gavinojbackendmodel.vo;


import com.Gavin.gavinojbackendmodel.entity.Competition;
import com.Gavin.gavinojbackendmodel.entity.Question;
import lombok.Data;

import java.util.List;

/**
 * @author: Gavin
 * @description:
 * @className: CompetitionQuestionVO
 * @date: 2024/4/27 19:07
 * @version:0.1
 * @since: jdk14.0
 */
@Data
public class CompetitionQuestionVO {

    List<Question> questions;
    Competition competition;
}

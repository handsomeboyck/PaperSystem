package com.ccnu.paper_service.mapper;

import com.ccnu.paper_service.model.entity.DefendantOne;
import com.ccnu.paper_service.provider.DefendantOneProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 16:53 2020/7/14
 */
public interface OneDefendantMapper {
    Integer saveOneDefendant(DefendantOne defendantOne);

    List<DefendantOne> listDefendantByLawyerId(@Param("lawyer_id") Integer lawyerId);

   @UpdateProvider(type = DefendantOneProvider.class,method = "UpdateDefendantOne")
    Integer updateDefendantOne(DefendantOne defendantOne);


   @Delete("delete  from defendant_one where id =#{id}")
   Integer deleteById(Integer id);

   @Select("select * from defendant_one where name like  CONCAT('%',#{name},'%') order by id desc")
   List<DefendantOne> findByName(@Param("name") String name);

   @Select("select count(*) from defendant_one")
   int count();

   @Select("select * from defendant_one limit #{start},#{end} ")
   List<DefendantOne> selectByPage(@Param("start") int start,@Param("end") int end);


}

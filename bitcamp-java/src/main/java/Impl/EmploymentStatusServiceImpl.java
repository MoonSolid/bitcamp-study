package Impl;

import org.springframework.stereotype.Component;
import com.portfoli.dao.EmploymentStatusDao;
import com.portfoli.domain.EmploymentStatus;
import com.portfoli.service.EmploymentStatusService;

@Component
public class EmploymentStatusServiceImpl implements EmploymentStatusService {

  EmploymentStatusDao employmentStatusDao;

  public EmploymentStatusServiceImpl(EmploymentStatusDao employmentStatusDao) {
    this.employmentStatusDao = employmentStatusDao;
  }

  @Override
  public void add(EmploymentStatus employmentStatus) throws Exception {
    employmentStatusDao.insert(employmentStatus);
  }

}

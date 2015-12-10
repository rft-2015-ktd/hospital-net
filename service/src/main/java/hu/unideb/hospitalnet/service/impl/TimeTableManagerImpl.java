package hu.unideb.hospitalnet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.hospitalnet.core.dao.TimeTableDao;
import hu.unideb.hospitalnet.core.entity.TimeTable;
import hu.unideb.hospitalnet.service.TimeTableManager;
import hu.unideb.hospitalnet.service.converter.impl.TimeTableConverter;
import hu.unideb.hospitalnet.vo.TimeTableVo;

@Service("timeTableManager")
@Transactional(propagation = Propagation.REQUIRED)
public class TimeTableManagerImpl implements TimeTableManager {

	@Autowired
	private TimeTableDao timeTableDao;

	private TimeTableConverter converter = new TimeTableConverter();

	@Override
	public Boolean hasCoveringTimeTable(Long workerId, TimeTableVo tt) {
		TimeTable tte = timeTableDao.findByWorkerAndDate(workerId, tt.getFrom(), tt.getTo());
		return tte != null;
	}

	@Override
	public Long addTimeTableToWorker(Long workerId, TimeTableVo newTimeTable) {

		TimeTable tt = converter.toEntity(newTimeTable);
		tt = timeTableDao.save(tt);

		try {
			timeTableDao.addTimeTableToWorker(workerId, tt.getId());
		} catch (Exception e) {
			return null;
		}

		return tt.getId();
	}

}

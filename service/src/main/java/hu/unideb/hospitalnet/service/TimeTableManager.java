package hu.unideb.hospitalnet.service;

import hu.unideb.hospitalnet.vo.TimeTableVo;

public interface TimeTableManager {

	Boolean hasCoveringTimeTable(Long workerId, TimeTableVo tt);

	Long addTimeTableToWorker(Long workerId, TimeTableVo newTimeTable);

}

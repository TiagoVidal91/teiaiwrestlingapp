import data from '../mockData.json';
import TeiaiTable from '../components/TeiaiTable/TeiaiTable';
import {filterData} from "../helperFunctions";

const StreakPage = () => {
    var headers= ["Name", "Brand", "Locker room", "Wins", "Loses", "Matches Total", "Percentage Win", "Streak"];
    var objectFields=  ["inRingName", "brandId", "lockerId", "numberOfWins", "numberOfLosses", "numberOfMatches", "percentageOfWins", "wrestlingStreak"];
    var filteredData = filterData(data.content, objectFields);
    return (
        <>
            <h1>Score!!!!</h1>
            <TeiaiTable tableData={filteredData} tableHeaders={headers} objectFields={objectFields} id={"streakTable"} numberPages={data.totalPages}/>
        </>
    )
}
export default StreakPage


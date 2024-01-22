import React, { useCallback, useState } from 'react';
import Light from './Light';

const SweetHome = () => {
    const [masterOn, setMasterOn] = useState(false);
    const [kitchenOn, setKitchenOn] = useState(false);
    const [bathOn, setBathOn] = useState(false);

    // 각 room의 불을 키고 끄는 이벤트들
    // master
    // const toggleMaster = () => {
    //     setMasterOn(!masterOn);
    // }
    
    // kitchen
    // const toggleKitchen = () => {
    //     setKitchenOn(!kitchenOn);
    // }
    
    // bath
    // const toggleBath = () => {
    //     setBathOn(!bathOn);
    // }
    
    
    // 각 room의 불을 키고 끄는 이벤트들 -> useCallback을 이용
    // useCallback을 사용해서 해당하는 것들에 대해서만 이벤트가 발생하도록 함
    // useCallback을 적용하면 해당 변수가 바뀔 경우에만 렌더링이 일어남
    // master
    const toggleMaster = useCallback (() => {
        setMasterOn(!masterOn);
    }, [masterOn]);
    
    // kitchen
    const toggleKitchen = useCallback(() => {
        setKitchenOn(!kitchenOn);
    }, [kitchenOn]);
    
    // bath
    const toggleBath = useCallback(() => {
        setBathOn(!bathOn);
    }, [bathOn]);

    return (
        <div>
            <Light room={'침실'} on={masterOn} toggle={toggleMaster}/>
            <Light room={'주방'} on={kitchenOn} toggle={toggleKitchen}/>
            <Light room={'욕실'} on={bathOn} toggle={toggleBath}/>
        </div>
    );
};

export default SweetHome;
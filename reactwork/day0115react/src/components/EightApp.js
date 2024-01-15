// mui 이미지 사용 연습


import { AddAPhotoRounded, AddAlarmRounded, CameraAltOutlined, DownloadDone, DownloadForOffline, ImageAspectRatio, PhoneBluetoothSpeakerOutlined, PhotoAlbum, PhotoCameraBackOutlined, UpdateRounded } from '@mui/icons-material';
import React from 'react';

function EightApp(props) {
    return (
        <div>
            <h3 className='alert alert-danger'>EightApp</h3>
            <AddAPhotoRounded/>
            <AddAlarmRounded/>
            <CameraAltOutlined/>
            <UpdateRounded/>
            <DownloadDone/>
            <DownloadForOffline/>
            <PhotoAlbum/>
            <PhoneBluetoothSpeakerOutlined/>
            <ImageAspectRatio/>
            <PhotoCameraBackOutlined/>
        </div>
    );
}

export default EightApp;
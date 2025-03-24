import React from 'react';
import Button from '@mui/material/Button';
import Rating from '@mui/material/Rating';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import Box from '@mui/material/Box';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Divider from '@mui/material/Divider';
import InboxIcon from '@mui/icons-material/Inbox';
import DraftsIcon from '@mui/icons-material/Drafts';
import { Link } from '@mui/material';

export default function Example1 (){
    return(
        <>
            <h3> 버튼 </h3>
            <Button variant="contained"> MUI 버튼 </Button>
            <br/>
            <br/>
            <button type='button'> HTML 버튼 </button>
        
            <h3> 별 </h3>
            <Rating name="read-only" value={3} readOnly />

            <h3> 셀렉트  </h3>
            <FormControl fullWidth>
                <InputLabel id="demo-simple-select-label"> 부서 </InputLabel>
                <Select labelId="demo-simple-select-label" id="demo-simple-select" label="부서">
                    <MenuItem value={"인사팀"}> 인사팀 </MenuItem>
                    <MenuItem value={"영업팀"}> 영업팀 </MenuItem>
                    <MenuItem value={"개발팀"}> 개발팀 </MenuItem>
                </Select>
            </FormControl>

            <h3> 리스트 </h3>
            {/* BOX : (HTML 마크업 중 div 와 비슷) MUI 레이아웃(구역)을 구성할 때 쓰는 컴포넌트 */}
            <Box sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}>
                <nav aria-label="main mailbox folders">
                    {/* List : (HTML 마크업 중 ul , ol 과 비슷) MUI 에서 리스트 구성 시 사용되는 컴포넌트*/}
                    <List>
                        {/* ListItem : (HTML 마크업 중 li 와 비슷) MUI 에서 리스트 항목을 구성 시 사용되는 컴포넌트*/}
                        <ListItem disablePadding>
                            <ListItemButton>
                            <ListItemIcon>
                                <InboxIcon />
                            </ListItemIcon>
                            {/* Link 도 연결 가능*/}
                            <ListItemText primary={<Link to="/"> 인사관리 </Link>} />
                            </ListItemButton>
                        </ListItem>
                        <ListItem disablePadding>
                            <ListItemButton>
                            <ListItemIcon>
                                <DraftsIcon />
                            </ListItemIcon>
                            <ListItemText primary="부품관리" />
                            </ListItemButton>
                        </ListItem>
                    </List>
                </nav>
                {/* Divider : 구분선 */}
                <Divider />
                <nav aria-label="secondary mailbox folders">
                    <List>
                        <ListItem disablePadding>
                            <ListItemButton>
                            <ListItemText primary="Trash" />
                            </ListItemButton>
                        </ListItem>
                        <ListItem disablePadding>
                            <ListItemButton component="a" href="#simple-list">
                            <ListItemText primary="Spam" />
                            </ListItemButton>
                        </ListItem>
                    </List>
                </nav>
            </Box>
        </>
    )
}
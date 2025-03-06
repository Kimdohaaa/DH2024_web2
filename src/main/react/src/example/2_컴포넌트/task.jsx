// 250305 과제 //

import './task.css'
const ProductCard = ( props ) => {
    return (<>
            <div className='x'>
                <div className='item'> <h3> {props.title} </h3></div>
                <div className='item'> 가격 {props.price} </div>
                <div className='item'> {props.inStock == true ? <div className="true" > "재고있음" </div> : <div className="false" >"재고없음"</div>} </div>
                </div>
    </>);
  };
  
export default function Task( props ) {
    const products = [
      { title: "무선 키보드", price: 45000, inStock: true },
      { title: "게이밍 마우스", price: 32000, inStock: false },
      { title: "27인치 모니터", price: 280000, inStock: true }
    ];
    return (<>
        <div className="box">
            {products.map((product, index) => (
                    <ProductCard key={index} 
                        title={product.title}
                        price={product.price}
                        inStock={product.inStock}
                    />
            ))}
        </div>
    </>);
  }
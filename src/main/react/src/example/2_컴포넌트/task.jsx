// 250305 과제 //

import './task.css'
                    // props 객체를 구문 분해하여 각 변수로 저장
const ProductCard = ({title, price, inStock}) => { // 하나의 제품 정보를 표현하는 하위 UI 구역
    return (<>
            <div className='x'>
                <div className='item'> <h3> {title} </h3></div>
                {/* .toLocaleString() : 천 단위 콤마 라이브러리 */}
                <div className='item'> 가격 {price.toLocaleString()} </div>
                <div className='item'> {inStock == true ? <div className="true" > "재고있음" </div> : <div className="false" >"재고없음"</div>} </div>
            </div>
    </>);
  };
  
export default function Task( props ) { // 여러 개의 ProductCard 컴포넌트를 포함하는 상위 UI 구역
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